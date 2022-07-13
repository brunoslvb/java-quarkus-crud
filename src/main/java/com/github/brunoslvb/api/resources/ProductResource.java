package com.github.brunoslvb.api.resources;

import com.github.brunoslvb.api.models.Product;
import com.github.brunoslvb.api.models.ProductDTO;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> listAllProducts(){
        return Product.listAll();
    }

    @POST
    @Transactional
    public void saveProduct(ProductDTO dto){
        Product product = new Product();
        product.name = dto.name;
        product.price = dto.price;
        Product.persist(product);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void saveProduct(@PathParam("id") Long id, ProductDTO dto){
        Optional<Product> productFound = Product.findByIdOptional(id);

        if(productFound.isEmpty())
            throw new NotFoundException();

        Product product = productFound.get();
        product.name = dto.name;
        product.price = dto.price;
        Product.persist(product);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void saveProduct(@PathParam("id") Long id){
        Optional<Product> productFound = Product.findByIdOptional(id);

        productFound.ifPresentOrElse(
            Product::delete,
            () -> { throw new NotFoundException(); }
        );
    }

}
