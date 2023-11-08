package com.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entites.Category;
import com.entites.Comment;
import com.entites.Post;
import com.entites.User;
import com.exceptions.ResourceNotFoundException;
import com.payloads.CategoryDto;
import com.payloads.CommentDto;
import com.repositories.CommentRepo;
import com.repositories.PostRepo;
import com.repositories.UserRepo;
import com.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId,Integer userId) {

		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
		
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","user id",userId));
		
		Comment comment = DtoToComment(commentDto);
		
		comment.setPost(post);
		comment.setUser(user);
		Comment savedComment = commentRepo.save(comment);
	
		
		return CommentToDto(savedComment);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment comment = commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","comment id",commentId));
		
		commentRepo.delete(comment);
		
	}

	
	public Comment DtoToComment(CommentDto commentDto)
	{
		Comment comment = modelMapper.map(commentDto, Comment.class);
		return comment;
	}
	
	public CommentDto CommentToDto(Comment comment)
	{
		CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
		return commentDto;
	}
	
}
