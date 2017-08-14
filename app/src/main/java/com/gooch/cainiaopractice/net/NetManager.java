package com.gooch.cainiaopractice.net;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpMethod;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.base.Request;
import com.lzy.okrx2.adapter.ObservableBody;

import java.lang.reflect.Type;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class NetManager {
    public static <T> Observable<T> request(HttpMethod method, String url, @NonNull Type type, Map<String, String> paramMap) {
        Request<T, ? extends Request> request;
        if (method == HttpMethod.GET) request = OkGo.get(url);
        else if (method == HttpMethod.POST) request = OkGo.post(url);
        else if (method == HttpMethod.PUT) request = OkGo.put(url);
        else if (method == HttpMethod.DELETE) request = OkGo.delete(url);
        else if (method == HttpMethod.HEAD) request = OkGo.head(url);
        else if (method == HttpMethod.PATCH) request = OkGo.patch(url);
        else if (method == HttpMethod.OPTIONS) request = OkGo.options(url);
        else if (method == HttpMethod.TRACE) request = OkGo.trace(url);
        else request = OkGo.get(url);

        HttpHeaders headers = new HttpHeaders();
        request.headers(headers);

        if (paramMap != null && paramMap.size() > 0) {
            HttpParams params = new HttpParams();
            for (Map.Entry<String, String> item : paramMap.entrySet()) {
                params.put(item.getKey(), item.getValue());
            }
            request.params(params);
        }

        request.converter(new JsonConvert<T>(type));
        return request.adapt(new ObservableBody<T>());
    }
}
