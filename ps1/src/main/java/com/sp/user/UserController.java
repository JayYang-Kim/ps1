package com.sp.user;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController
 * Jsp와 같은 view를 만들어낼 목적이 아닌 REST 방식의 데이터를 처리하는데 사용하는 어노테이션
 * @ResponseBody사 포함되어 있어 AJAX 작업만 수행하는 컨트롤러를 작성할때 사용
 * 
 * @Controller로 컨트롤러를 만든 경우에는 @ResponseBody가 필요하다.
 */
@RestController("user.userController")
public class UserController {
	@RequestMapping(value="/user/data", produces="text/html;charset=UTF-8")
	public String dataSubmit(@RequestParam String id,
			@RequestParam String callback) throws Exception {
		String result = null;
		
		String name = "홍길동";
		int age = 20;
		
		JSONObject job = new JSONObject();
		job.put("id", id);
		job.put("name", name);
		job.put("age", age);
		job.put("result", "성인");
		
		result = callback + "(" + job.toString() + ")";
		
		//System.out.println("==========" + result);
		
		return result;
	}
}
