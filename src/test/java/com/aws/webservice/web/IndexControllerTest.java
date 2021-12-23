package com.aws.webservice.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        //given
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>스프링부트 웹서비스</title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "\n" +
                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>스프링부트로 시작하는 웹 서비스 Ver.2</h1>\n" +
                "<div class=\"col-md-12\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-6\">\n" +
                "            <a href=\"/posts/save\" role=\"button\" class=\"btn btn-primary\">글 등록</a>\n" +
                "                <a href=\"/oauth2/authorization/google\" class=\"btn btn-success active\" role=\"button\">Google Login</a>\n" +
                "                <a href=\"/oauth2/authorization/naver\" class=\"btn btn-secondary active\" role=\"button\">Naver Login</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <br>\n" +
                "    <!-- 목록 출력 영역 -->\n" +
                "    <table class=\"table table-horizontal table-bordered\">\n" +
                "        <thead class=\"thead-strong\">\n" +
                "        <tr>\n" +
                "            <th>게시글번호</th>\n" +
                "            <th>제목</th>\n" +
                "            <th>작성자</th>\n" +
                "            <th>최종수정일</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody id=\"tbody\">\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>\n" +
                "\n" +
                "<script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\n" +
                "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n" +
                "\n" +
                "<!--index.js 추가-->\n" +
                "<script src=\"/js/app/index.js\"></script>\n" +
                "</body>\n" +
                "</html>");

    }

}