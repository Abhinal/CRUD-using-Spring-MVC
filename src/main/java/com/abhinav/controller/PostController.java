package com.abhinav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.abhinav.bean.PostBean;
import com.abhinav.bean.PostManagerBean;
import com.abhinav.bean.ResponseBean;
import com.abhinav.service.PostService;

@Controller
public class PostController {
	
	ResponseBean rb = new ResponseBean();
	PostService postService = new PostService();
	PostManagerBean postManagerBean = null;
	
	@GetMapping("/post")
	public ModelAndView getPost() {
		ModelAndView mv = new ModelAndView("post");
		if(postManagerBean == null)
			postManagerBean = postService.getPostApi();
		mv.addObject("data", rb);
		mv.addObject("posts", postManagerBean.getAllPosts());
		return mv;
	}
	
	@PostMapping("/post")
	public ModelAndView fetchPost() {
		return getPost();
	}
	
	@PostMapping("/create-post")
	public ModelAndView addPost(@RequestParam("title") String title, @RequestParam("body") String body) {
		postManagerBean.addPost(new PostBean(postManagerBean.getUniqueId(), title, body, rb.getId()));	
		ModelAndView mv = new ModelAndView();
		RedirectView redirectView = new RedirectView("/post", true);
		mv.setView(redirectView);
		return mv;
	}
	
	@DeleteMapping("/post")
	public void deletePost(@RequestParam("postId") Integer id) {
		postService.deletePostApi(id);
		postManagerBean.deletePost(id);
	}
	
	@PutMapping("/post")
	public void updatePost(@RequestParam("postId") Integer id, @RequestParam("title") String title, @RequestParam("body") String body) {
		PostBean post = postManagerBean.getPost(id);		
		post.setTitle(title);
		post.setBody(body);
	}
}
