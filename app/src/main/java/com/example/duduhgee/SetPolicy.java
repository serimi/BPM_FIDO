package com.example.duduhgee;

public class SetPolicy {
//    String appID = "https://192.168.0.2:443/ResgisterRequest.php";

    public class Version{
        public int major;
        public int minor;
    }

    public enum Operation {
        Reg,   //1
        Auth,  //2
        Dereg  //3
    }

    public class OperationHeader{
        Version upv;
        Operation op;
        public String appID;
        public String serverdata;
    }

    public class FinalChallengeParams{
        public String appID;
        public String challenge;
        public String facetID = "";  //uri..? 서버에서 준 list?
        public ChannelBinding channelBinding;
    }

    public class Extension {
        public String id;
        public String data;
        public boolean fail_if_unknown;
    }

    public class AuthenticatorRegistrationAssertion {
        public String assertionScheme;
        public String assertion;
        //public Extension[] exts; 굳이 필요한가
    }

    public class ChannelBinding {
        public String serverEndPoint;  //질문
        public String tlsServerCertificate;  //activity파일에서 불러오면 될듯
        public String cid_pubkey;
    }

    public class RegistrationResponse{
        OperationHeader header;
        public String fcParams;  //FinalChallengeParams을 utf-8 encoding
        AuthenticatorRegistrationAssertion[] assertions;
    }
}
