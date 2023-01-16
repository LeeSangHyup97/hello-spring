package hello.hellospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hello.hellospring.service.OAuthService;

@Controller
public class UserController {

    @Autowired
    OAuthService kakao;

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping ("/oauth/kakao")
    public void login(@RequestParam String code) {
        String access_Token = kakao.getKakaoAccessToken(code);
        System.out.println("controller access_token : " + access_Token);
    }

}

//@RestController
//@AllArgsConstructor
//@RequestMapping("/oauth")
//public class UserController {
//
//    @Autowired
//    private OAuthService kakao;
//
//    @ResponseBody
//    @GetMapping (value="/kakao")
//    public void UserInfoSet(@RequestParam String code) {
//        String access_Token = kakao.getKakaoAccessToken(code);
//        System.out.println("controller access_token : " + access_Token);
//    }
//
//
////    public String login(@RequestParam("code") String code) {
////        String access_Token = kakao.getKakaoAccessToken(code);
////        System.out.println("controller access_token : " + access_Token);
////
////        return "index";
////    }
//
//    @RequestMapping(value="/")
//    public String index() {
//        return "index";
//    }
//
////    @RequestMapping(value="/login")
////    public String login(@RequestParam("code") String code) {
////        String access_Token = kakao.getKakaoAccessToken(code);
////        System.out.println("controller access_token : " + access_Token);
////
////        return "index";
////    }
//
//}
