// IShop.aidl
package com.ideal.jalen.ipc.aidl;
import com.ideal.jalen.ipc.aidl.Product;

interface IShop {
   Product buy();
   void setProduct(in Product product);
}
