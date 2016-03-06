package dojo.githubusercore.retrofit;

import retrofit.Call;

/**
 * Created by JGabrielFreitas on 06/03/16.
 */
public interface RetrofitExecutableInterface<T> {

    void executable(Call<T> api);
}
