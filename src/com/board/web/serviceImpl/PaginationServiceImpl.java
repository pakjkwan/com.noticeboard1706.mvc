package com.board.web.serviceImpl;

import com.board.web.service.PaginationService;

public class PaginationServiceImpl implements PaginationService{

	@Override
	public String[] calculateRows(String[] params) {
		String[] rowValues=new String[6];
		int pageNumber=Integer.parseInt(params[0]);
		int theNumberOfRows=Integer.parseInt(params[1]);
		int rowsPerPage=Integer.parseInt(params[2]);
		int pagesPerBlock=Integer.parseInt(params[3]);
		
		
	    int	theNumberOfPages = (theNumberOfRows % rowsPerPage == 0) ? theNumberOfRows / rowsPerPage : theNumberOfRows / rowsPerPage + 1,
			startPage = pageNumber - ((pageNumber - 1) % pagesPerBlock),
			endPage = ((startPage + rowsPerPage - 1) < theNumberOfPages) ? startPage + pagesPerBlock - 1 : theNumberOfPages,
			startRow = (pageNumber - 1) * rowsPerPage + 1, 
			endRow = pageNumber * rowsPerPage,
			prevBlock = startPage - pagesPerBlock, 
			nextBlock = startPage + pagesPerBlock;
		rowValues[0]=String.valueOf(startRow);
		rowValues[1]=String.valueOf(endRow);
		rowValues[2]=String.valueOf(startPage);
		rowValues[3]=String.valueOf(endPage);
		rowValues[4]=String.valueOf(prevBlock);
		rowValues[5]=String.valueOf(nextBlock);
		return rowValues;
	}

}
