package com.selimhorri.app.helper;

import com.selimhorri.app.domain.Category;
import com.selimhorri.app.domain.Product;
import com.selimhorri.app.dto.CategoryDto;
import com.selimhorri.app.dto.ProductDto;

public interface ProductMappingHelper {
	
	public static ProductDto map(final Product product) {
		return ProductDto.builder()
				.productId(product.getProductId())
				.productTitle(product.getProductTitle())
				.imageUrl(product.getImageUrl())
				.priceUnit(product.getPriceUnit())
				.categoryDto(
						CategoryDto.builder()
							.categoryId(product.getCategory().getCategoryId())
							.categoryTitle(product.getCategory().getCategoryTitle())
							.build())
				.build();
	}
	
	public static Product map(final ProductDto productDto) {
		return Product.builder()
				.productId(productDto.getProductId())
				.productTitle(productDto.getProductTitle())
				.imageUrl(productDto.getImageUrl())
				.priceUnit(productDto.getPriceUnit())
				.category(
						Category.builder()
							.categoryId(productDto.getCategoryDto().getCategoryId())
							.categoryTitle(productDto.getCategoryDto().getCategoryTitle())
							.build())
				.build();
	}
	
	
	
}










