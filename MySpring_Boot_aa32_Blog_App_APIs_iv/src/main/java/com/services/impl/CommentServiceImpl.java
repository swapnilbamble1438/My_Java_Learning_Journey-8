package com.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entites.Category;
import com.entites.Comment;
import com.entites.Post;
import com.exceptions.ResourceNotFoundException;
import com.payloads.CategoryDto;
import com.payloads.CommentDto;
import com.repositories.CommentRepo;
import com.repositories.PostRepo;
import com.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
		
		Comment comment = DtoToComment(commentDto);
		
		comment.setPost(post);
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
