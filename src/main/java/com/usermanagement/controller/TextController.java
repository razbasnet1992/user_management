package com.usermanagement.controller;

import com.twilio.http.TwilioRestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sun.security.krb5.Credentials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//@Controller
//public class TextController {
//    // Find your Account Sid and Token at twilio.com/user/account
//    private static final String ACCOUNT_SID = "AC943749fb70ada695ed5537b046733afd";
//    private static final String AUTH_TOKEN = "27870e2f3ddedc54d2d0f4b4b23eb974";
//    private static final String TWILIO_NUMBER = "+19292576504";
//    private TwilioRestClient client;
//
//
//    public class SendSms extends HttpServlet {
//        private Logger logger = Logger.getLogger(SendSms.class.getName());
//        private TwilioRestClient client;
//        private Credentials credentials;
//
//        @Override
//        public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//            final String twilioAccountSid = System.getenv(ACCOUNT_SID);
//            final String twilioAuthToken = System.getenv(AUTH_TOKEN);
//            final String twilioNumber = System.getenv(TWILIO_NUMBER);
//            final String toNumber = (String) twilioNumber;
//            String message = "prova";
//            TwilioRestClient.
//            client = new TwilioRestClient(twilioAccountSid, twilioAuthToken);
//            sendMessage(toNumber, message);
//        }
//
//        public void sendMessage(String to, String message) {
//            List<NameValuePair> params = getParams(to, message);
//
//            try {
//                this.client.getAccount().getMessageFactory().create(params);
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        }
//
//        private List<NameValuePair> getParams(String to, String message) {
//            List<NameValuePair> params = new ArrayList<>();
//            params.add(new BasicNameValuePair("Body", message));
//            params.add(new BasicNameValuePair("To", to));
//            params.add(new BasicNameValuePair("From", to));
//
//            return params;
//        }
//
//
//    @GetMapping("greet")
//    public String greet(){
//        return "greeting";
//    }
//}
