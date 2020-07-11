package com.app.breeze.utils.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Slf4j
public class Test {



    public static String doGet(String url, Map<String, Object> params)throws IOException {
        String result = null;
        if (StringUtils.isEmpty(url)) {
            log.info("warn:doGet url is null or '' ");
            return result;
        } else {
            List<NameValuePair> pairList = new ArrayList(params.size());
            Iterator var4 = params.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var4.next();
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }

            CloseableHttpResponse response = null;
            InputStream instream = null;
            CloseableHttpClient httpclient = HttpClients.createDefault();

            try {
                URIBuilder URIBuilder = new URIBuilder(url);
                URIBuilder.addParameters(pairList);
                URI uri = URIBuilder.build();
                HttpGet httpGet = new HttpGet(uri);
                httpGet.addHeader("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsibXMtZGVzIiwibXMtc2VhcmNoIiwibXMtaG1zLXVzZXIiLCJtcy1obXMtY29tcG9uZW50IiwibXMtaG1zIiwibXMtdGVsZW1lZCIsIm1zLWluc3BlY3Rpb24iLCJtcy1haWQiXSwic2NvcGUiOlsicmVhZCJdLCJleHAiOjE2NzAzMzE4MTEsImF1dGhvcml0aWVzIjpbIlJPTEVfSE1TIiwiUk9MRV9VU0VSIiwiUk9MRV9DTElFTlQiXSwianRpIjoiN2JlNjlhN2EtM2NhNS00MmVmLTlhZWYtZDVhZjU1ZjdlNWQzIiwiY2xpZW50X2lkIjoiaGllcmFyY2hpY2FsbWVkaWNhbENMSUVOVHF1eWl5dWFuMjAxNjAzMDQifQ.8ZkVg0pOVlj1h5dCIlrpg4MZL3SL26hSfRZ1oGwp2Sc");
                response = httpclient.execute(httpGet);
                int statusCode = response.getStatusLine().getStatusCode();
                log.info("doGet statusCode:{}", statusCode);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    instream = entity.getContent();
                    result = IOUtils.toString(instream, "UTF-8");
                }
            } catch (IOException var16) {
                log.error("doGet  IO ERROR :{}", var16.getMessage());
            } catch (URISyntaxException var17) {
                log.error("doGet URISyntaxException :{}", var17.getMessage());
            } finally {
                if (null != instream) {
                    instream.close();
                }

                if (null != response) {
                    response.close();
                }

                if (null != httpclient) {
                    httpclient.close();
                }

                log.info("close  instream response httpClient  connection succ");
            }

            return result;
        }
    }



    public static void main(String[] args)throws IOException{
        String url="https://ms.kyeegroup.com/ms-hms/patientsCircles/doctors";
        Map<String, Object> params=new HashMap<>();
        params.put("hospitalId","7730009");
        String res= doGet(url,params);
        System.out.println(res);

    }
}
