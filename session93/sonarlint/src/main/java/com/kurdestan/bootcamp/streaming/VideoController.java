package com.kurdestan.bootcamp.streaming;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/video")
public class VideoController {

@Autowired
VideoStreamService service;










    @GetMapping( value = "/videoStream/")

    public void stream5(HttpServletRequest req, HttpServletResponse response)
            throws Exception {


          service.  renderMergedOutputModel(req,response);


    }

    @GetMapping(value = "/videoStream/{networspeed}" )
    public void findByRoom(@PathVariable("networspeed") String networkSpeed,HttpServletRequest  req,HttpServletResponse response) throws Exception {

            service.renderMergedOutputModelWithSpeed(networkSpeed,req,response);



    }











    @GetMapping(value="/download")
    public void getDownload(HttpServletResponse response)  {
      service.download(response);

    }

}



