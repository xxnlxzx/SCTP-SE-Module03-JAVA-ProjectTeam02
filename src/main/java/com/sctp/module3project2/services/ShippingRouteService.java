package com.sctp.module3project2.services;

import java.util.ArrayList;

import com.sctp.module3project2.entity.ShippingRoute;

// Edited by wei kang
public interface ShippingRouteService {
    ShippingRoute saveShippingRoute(ShippingRoute shippingRoute);

    ShippingRoute getShippingRoute(int id);

    ArrayList<ShippingRoute> getAllShippingRoutes();

    ShippingRoute updateShippingRoute(int id, ShippingRoute shippingRoute);

    void deleteShippingRoute(int id);
}
