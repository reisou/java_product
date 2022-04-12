package com.firstdevelop.boot.service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.entity.Product;
import com.firstdevelop.boot.form.ProductForm;
import com.firstdevelop.boot.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> searchAll() {
		return productMapper.searchAll();
	}
	
	public void regist(ProductForm form) {
		
		Product product = new Product();
		product.setAddress(form.getAddress());
		product.setClassProductId(Integer.parseInt(form.getClassProductId()));
		product.setCreateTime(LocalDateTime.now());
		product.setCreateUser("WEB");
		product.setProductAccount(new BigDecimal(form.getProductAccount()));
		product.setProductDate(LocalDateTime.now());
		product.setProductName(form.getProductName());
		product.setProductPrice(new BigDecimal(form.getProductPrice()));
		product.setUpdateTime(LocalDateTime.now());
		product.setCreateUser("WEB");
		
		productMapper.regist(product);
	}
	
	public void delete(Integer productId) {
		
		Product product = new Product();
		product.setProductId(productId);
		productMapper.delete(product);
	}
	
    public boolean addBatchUser(List<Product> productList) {	
        return productMapper.addBatchProductList(productList) > 0;	
    }	
	
    /**	
     * エクセル内容をアップロードして、DBに保存する処理	
     * @param fileName アップロードされたファイル名	
     * @param is エクセル内容	
     * @return 成功かどうか判定	
     */	
    public boolean importProductInfo(String fileName, InputStream is){	
        try {	
            List<Product> productList = upload(fileName, is);	
            return addBatchUser(productList); // バッチ処理	
        } catch (Exception e) {	
            e.printStackTrace();	
            return false;	
        }	
    }	
	
	
    // エクセル内容をDB保存用モデルに変更	
    private List<Product> upload(String fileName, InputStream is) throws Exception{	
    	
        Workbook workbook = getWorkbook(fileName,is);	
        	
        List<Product> productList = new ArrayList<>();	
        	
        int number = workbook.getNumberOfSheets(); // sheet数を取得	
        	
        for (int i = 0; i < number; i++) {	
            Sheet sheet = workbook.getSheetAt(i);	
            if (sheet != null){	
            	
                int rowNum = sheet.getLastRowNum();	
                	
                for (int j = 1; j <= rowNum; j++) {	
                	
                    Row row = sheet.getRow(j); 	
                    	
                    Product product = new Product();	
                    	
                    // Excleからの情報を設定	
                    // 商品名	
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING); 	
                    product.setProductName(row.getCell(0).getStringCellValue());	
                    	
                    // 販売値段	
                    row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);	
                    product.setProductPrice(new BigDecimal(row.getCell(1).getStringCellValue()));	
                    	
                    // 値段	
                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);	
                    product.setProductAccount(new BigDecimal(row.getCell(2).getStringCellValue()));	
                    	
                    // 産地	
                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);	
                    product.setAddress(row.getCell(3).getStringCellValue());	
                    	
                    // 商品クラスID	
                    row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);	
                    product.setClassProductId(Integer.parseInt(row.getCell(4).getStringCellValue()));	
                    	
                    // 関連の情報を設定	
                    product.setProductDate(LocalDateTime.now());	
                    product.setCreateTime(LocalDateTime.now());	
                    product.setUpdateTime(LocalDateTime.now());	
                    product.setCreateUser("WEB");	
                    product.setUpdateUser("WEB");	
                    	
                    productList.add(product);	
                }	
            }	
        }	
        return productList;	
    }	
	
    // アップロードされたファイルの種類を判定	
    private Workbook getWorkbook(String fileName,InputStream is) throws Exception{	
        Workbook workbook = null;	
        String name = fileName.substring(fileName.lastIndexOf("."));	
        System.out.println(name);	
        if (".xls".equals(name)){	
            workbook = new HSSFWorkbook(is);	
        }else if (".xlsx".equals(name)){	
            workbook = new XSSFWorkbook(is);	
        }else {	
            throw new Exception(" .xls/.xlsxのファイルをアップロードしてください");	
        }	
        return workbook;	
    }	

}
