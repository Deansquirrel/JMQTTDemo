package com.yuansong.study.client1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.study.client1.VO.HelloVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "01服务测试")
@RestController
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@ApiOperation("接口说明")
	@GetMapping("/test")
	public HelloVO test() {
		logger.debug("client1 test");
		HelloVO vo = new HelloVO();
		vo.setId(1L);
		vo.setMsg("client 1 test");
		return vo;
	}
	
	
}
