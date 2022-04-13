package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    public String hello(Model model) {
        model.addAttribute("date", "spring!!!");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 데이터를 응답 바디에다가 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // api 방식
    // 객체를 반환하고 ResponseBody -> HttpMessageConverter 동작 -> 객체 : Json / 문자 : String이 동작한다.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi (@RequestParam("name") String name) {

        // 객체생성성
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    // 객체생성 -> HelloController 안에서 Hello 클래스를 쓸 수 있다. HelloController.Hello
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
