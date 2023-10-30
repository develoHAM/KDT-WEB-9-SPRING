package com.example.spring_study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Hello {
    private int age;
    public Hello(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

// practice 2
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

@Controller
public class HelloController {
    @GetMapping("/hi")
    public String getHi(Model model) { //Model model: 컨트롤러 클래스안의 메서드가 파라미터로 받을 수 있는 객체

        Hello hello = new Hello(25);
        List<String> names = Arrays.asList("kim", "lee", "hong", "park");
        model.addAttribute("msg", "hi~~~");
        model.addAttribute("hello", "Spring World");
        model.addAttribute("utext", "<i>Hello</i>");
        model.addAttribute("value", "이름을 입력하세요.");
        model.addAttribute("with", "hello");
        model.addAttribute("link", "hi");
        model.addAttribute("img", "spring_logo.png");
        model.addAttribute("userRole", "user");
        model.addAttribute("isAdmin", false);
        model.addAttribute("names", names);
        model.addAttribute("classHello", hello);

        // practice 1
        model.addAttribute("age", 28);


        // ${..}: 변수 표현식
        // @{..}: URL 링크 표현식
        // *{..}: 선택 변수 표현식, 단, th:object
        // 컨트롤러 클래스에서 private String msg = "hi";
        // model.addAttribute("Msg", new HelloController());
        // 템플릿에서 <div th:object=${Msg}><h1 th:text=*{msg}></h1></div>
        return "hi";
    }

    // practice 2
    @GetMapping("/people")
    public String getPeople(Model model) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("홍길동", 24));
        people.add(new Person("김대원", 26));
        people.add(new Person("가나다", 18));
        people.add(new Person("마바사", 60));
        model.addAttribute("people", people);
        return "people";
    }

}
