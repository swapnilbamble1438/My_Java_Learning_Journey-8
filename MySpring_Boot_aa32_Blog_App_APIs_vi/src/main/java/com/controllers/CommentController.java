package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payloads.ApiResponse;
import com.payloads.CommentDto;
import com.services.CommentService;
import com.services.UserService;

@RestController
@RequestMapping("api/comment/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	

	// creating comment
	@PostMapping("/create/{postId}/{userId}")
	public ResponseEntity<CommentDto> createComment(
			@RequestBody CommentDto comment,
			@PathVariable("postId") Integer postId,
			@PathVariable("userId") Integer userId)
	{
		CommentDto createComment = commentService.createComment(comment, postId,userId);
		
		return new ResponseEntity<CommentDto>(createComment,HttpStatus.OK);
	
	}
	
	// deleting comment
	@DeleteMapping("/delete/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(
			@PathVariable("commentId") Integer commentId)
	{
		commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully !!",true),HttpStatus.OK);
	
	}
	
	
	
	
}
