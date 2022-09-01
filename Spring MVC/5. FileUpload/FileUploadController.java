package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@Log4j2

@Controller
@RequestMapping("/fileUpload/")
public class FileUploadController {

    // 1. upload 화면을 만들어보자
    @GetMapping("/page")
    public String  fileUploadPage() {
        log.debug("fileUploadPage() invoked.");

        return "fileUploadPage";

    }

    // 1-1. upload 화면을 만드는 다른 방법
    // 설정파일에 설정하기
    // <view-controller path="/fileUpload/page" view-name="fileUploadPage" status-code="200" />

    // 2. 파일업로드의 처리
    @PostMapping("/doit")
    public void DoFileUpload(@NonNull @RequestParam("files") List<MultipartFile> parts) {
        log.debug(" DoFileUpload() invoked.");

        log.info("\t - parts : {}", parts);

    }

}
