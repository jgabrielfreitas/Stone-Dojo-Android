package dojo.githubusercore.retrofit;

import android.app.ProgressDialog;
import android.content.Context;

import dojo.githubusercore.utils.Utils;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by JGabrielFreitas on 06/03/16.
 */
public final class RetrofitConsumer<T> implements RetrofitExecutableInterface<T> {

    boolean workInBackground = true;
    Context context;
    protected ProgressDialog dialog;
    private String dialogMessage;
    private String dialogTitle;
    private RetrofitCallback retrofitCallback;
    Class<?> errorClass;
    Retrofit retrofit;
    Call<T> api;
    private int responseCode;

    public RetrofitConsumer(Context context) {
        this.context = context;
        retrofit = Utils.createRetrofit(""); //BuildConfig.URL_API
    }

    public RetrofitConsumer(Context context, String url) {
        this.context = context;
        retrofit = Utils.createRetrofit(url);
    }

    private void executeFeedback() {

        if (workInBackground == false && context != null)
            dialog = ProgressDialog.show(context, dialogTitle, dialogMessage, false, false);
    }

    public void setRetrofitCallback(RetrofitCallback<T> retrofitCallback) {
        this.retrofitCallback = retrofitCallback;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setWorkInBackground(boolean workInBackground) {
        this.workInBackground = workInBackground;
    }

    public void setDialogMessage(String dialogMessage) {
        this.dialogMessage = dialogMessage;
    }

    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    public void executable(Call<T> api) {
        this.api = api;
    }

    public void run() {


        executeFeedback();
        if (retrofitCallback != null) {
            api.enqueue(new Callback<T>() {
                public void onResponse(Response<T> response, Retrofit retrofit) {

                    responseCode = response.code();

                    try {
                        if (responseCode <= 202)
                            retrofitCallback.onSuccess(response.body());
                        else {
                            if (responseCode >= 400 && responseCode < 500)
                                if (response.body() != null)
                                    retrofitCallback.clientError(response.body(), response);
                                else {
                                    retrofitCallback.clientError(retrofit.responseConverter(errorClass, errorClass.getAnnotations()).convert(response.errorBody()), response);
                                }
                            else
                                retrofitCallback.internalServerError();
                        }
                    } catch (Exception e) {
                        retrofitCallback.onError(e);
                        e.printStackTrace();
                    }

                    tryCloseDialog();
                }

                public void onFailure(Throwable t) {
                    retrofitCallback.onError(t);
                    tryCloseDialog();
                }
            });
        }
    }

    private void tryCloseDialog() {

        try{

            if (dialog != null)
                if (dialog.isShowing())
                    dialog.dismiss();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setErrorClass(Class<?> errorClass) {
        this.errorClass = errorClass;
    }

    public int getResponseCode() {
        return responseCode;
    }
}