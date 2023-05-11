import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Product } from './_model/product.model';
import { Observable, map } from 'rxjs';
import { ProductService } from './_services/product.service';
import { ImageProcessingService } from './image-processing-service.service';


@Injectable({
  providedIn: 'root'
})

export class BuyProductResolverService implements Resolve<Product[]>{

  //let isSingleProductCheckout = false;

  constructor(private productServcice: ProductService,
    private imageProcessingService: ImageProcessingService) { 

    }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Product[] | Observable<Product[]> | Promise<Product[]> {
   
    const id = route.paramMap.get("id");
   
    
     const isSingleProductCheckout = route.paramMap.get("isSingleProductCheckout");
     return this.productServcice.getProductDetails(isSingleProductCheckout, id)
    .pipe(
      map(
        (x: Product[], i) => x.map((product: Product) => this.imageProcessingService.createImages(product))
      )
    )
  }
}
