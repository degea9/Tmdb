package movietube.tuandang.android.com.movietube.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response

const val API_KEY = "c3feddfa14209fb76f2c75c7737b72d0";
class ApiKeyInterceptor:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url().newBuilder().addQueryParameter("api_key",API_KEY).build();
        val request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }
}