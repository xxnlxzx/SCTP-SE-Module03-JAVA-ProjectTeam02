package com.sctp.module3project2.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sctp.module3project2.entity.ShippingRoute;
import com.sctp.module3project2.services.ShippingRouteService;

// Edited by Wei Kang
@RestController
@RequestMapping("/api/shippingRoute")
public class ShippingRouteController {
    private ShippingRouteService shippingRouteService;

    public ShippingRouteController(ShippingRouteService shippingRouteService){
        this.shippingRouteService = shippingRouteService;
    }

    @PostMapping("")
    public ResponseEntity<ShippingRoute> saveShippingRoute(@RequestBody ShippingRoute shippingRoute){
        ShippingRoute newShippingRoute = shippingRouteService.saveShippingRoute(shippingRoute);
        return new ResponseEntity<>(newShippingRoute, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingRoute> getShippingRoute(@PathVariable int id) {
        ShippingRoute foundShippingRoute = shippingRouteService.getShippingRoute(id);
        return new ResponseEntity<>(foundShippingRoute, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<ShippingRoute>> getAllShippingRoute(){
        ArrayList<ShippingRoute> allShippingRoute = shippingRouteService.getAllShippingRoutes();
        return new ResponseEntity<>(allShippingRoute, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingRoute> updateShippingRoute(@PathVariable int id, @RequestBody ShippingRoute shippingRoute){
        ShippingRoute updatedShippingRoute = shippingRouteService.updateShippingRoute(id, shippingRoute);
        return new ResponseEntity<>(updatedShippingRoute, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteShippingRoute(@PathVariable int id){
        shippingRouteService.deleteShippingRoute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
