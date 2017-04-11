package com.nicky.practice.forbook.prime;

import java.io.PrintStream;

public class RowColumnPagePrinter {
    private int rowsPerPage;
    private int columnsPerPage;
    private int numberPerPage;
    private String pageHeader;
    private PrintStream printStream;
    
    public RowColumnPagePrinter(int rowsPerpage, int columnsPerpage, String pageHeader){
        this.rowsPerPage = rowsPerpage;
        this.columnsPerPage = columnsPerpage;
        this.pageHeader = pageHeader;
        numberPerPage = rowsPerpage * columnsPerpage;
        printStream = System.out;
    }
    
    public void print(int data[]) {
        int pageNumber = 1;
        for (int firstIndexOnPage = 0;
                firstIndexOnPage < data.length;
                firstIndexOnPage += numberPerPage) {
            int lastIndexOnPage = 
                    Math.min(firstIndexOnPage + numberPerPage -1 , 
                            data.length - 1);
            printPageHeader(pageHeader, pageNumber);
            printPage(firstIndexOnPage, lastIndexOnPage, data);
            printStream.println("\f");
            pageNumber++;
        }
    } 
    
    private void printPage(int firstIndexOnPage, int lastIndexOnPage, int[] data) {
        int firstIndexOfLastRowOnPage = firstIndexOnPage + rowsPerPage - 1;
        for(int firstIndexInRow = firstIndexOnPage;
                firstIndexInRow <= firstIndexOfLastRowOnPage;
                firstIndexInRow++) {
            printRow(firstIndexInRow, lastIndexOnPage, data);
            printStream.println("");
        }
    }
    
    public void printRow(int firstIndexInRow, int lastIndexOnPage, int[] data) {
        for(int column = 0; column < columnsPerPage; column++) {
            int index = firstIndexInRow + column * rowsPerPage;
            if(index < lastIndexOnPage) {
                printStream.format("%10d", data[index]);
            }
        }
    }
    
    private void printPageHeader(String pageHeader, int pageNumber) {
        printStream.println(pageHeader + " --- page " + pageNumber);
        printStream.println("");
    }
    
    public void setOutPut(PrintStream printStream) {
        this.printStream = printStream;
    }

}
