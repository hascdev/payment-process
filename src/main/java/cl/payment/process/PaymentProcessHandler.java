package cl.payment.process;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.khipu.ApiClient;
import com.khipu.api.client.PaymentsApi;
import com.khipu.api.model.PaymentsCreateResponse;

import cl.aws.common.dto.lambda.GenericLambdaResponse;

public class PaymentProcessHandler implements RequestHandler<Payment, GenericLambdaResponse> {

    @Override
    public GenericLambdaResponse handleRequest(Payment payment, Context context) {
    	
    	GenericLambdaResponse response = new GenericLambdaResponse();
        
    	try {
    		
    		if (payment == null || payment.getSubject() == null || payment.getAmount() == null) {
    			throw new Exception("Missing the required parameter when calling payment"); 
    		}
    		
			int receiverId = 00000;
			String secretKey = "xxxxx";

			ApiClient apiClient = new ApiClient();
			apiClient.setKhipuCredentials(receiverId, secretKey);
			apiClient.setPlatform("demo-client", "2.0");
			// apiClient.setDebugging(true);
			PaymentsApi paymentsApi = new PaymentsApi();
			paymentsApi.setApiClient(apiClient);

			Map<String, Object> options = new HashMap<>();
			options.put("transactionId", System.currentTimeMillis());
			options.put("returnUrl", "http://mi-ecomerce.com/backend/return");
			options.put("cancelUrl", "http://mi-ecomerce.com/backend/cancel");
			options.put("pictureUrl", "http://mi-ecomerce.com/pictures/foto-producto.jpg");
			options.put("notifyUrl", "http://mi-ecomerce.com/backend/notify");
			options.put("notifyApiVersion", "1.3");

			PaymentsCreateResponse paymentsCreateResponse = paymentsApi.paymentsPost(payment.getSubject()
			        , payment.getCurrency() //Moneda
			        , payment.getAmount() //Monto
			        , options //campos opcionales
			);

			String url = "https://khipu.com/payment/webpayPsp/" + paymentsCreateResponse.getPaymentId();
			
			response.setObject(url);
			
    	} catch (Exception e) {
			response.setCode(GenericLambdaResponse.CODE_ERROR);
			response.setMessage(e.getMessage());
		}
        
        return response;
    }

}
