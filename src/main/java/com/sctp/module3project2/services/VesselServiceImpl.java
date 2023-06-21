package com.sctp.module3project2.services;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sctp.module3project2.entity.Booking;
import com.sctp.module3project2.repository.BookingRepository;
import com.sctp.module3project2.entity.ShippingRoute;
import com.sctp.module3project2.entity.Vessel;
import com.sctp.module3project2.repository.ShippingRouteRepository;
import com.sctp.module3project2.repository.VesselRepository;

import java.util.Optional;
import java.util.List;
// Edited by Afif
@Service
public class VesselServiceImpl implements VesselService {

    private final VesselRepository vesselRepository;
    // private final ShippingRouteRepository shippingRouteRepository;
    // private final BookingRepository bookingRepository;

  public VesselServiceImpl(VesselRepository vesselRepository) {
        this.vesselRepository = vesselRepository;
        // this.shippingRouteRepository = shippingRouteRepository;
        // this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Vessel> findAllVessels() {
    return vesselRepository.findAll();
    }

    @Override
    public  Vessel saveVessel(Vessel vessel) {   
    return vesselRepository.save(vessel);
    }

    @Override
    public Optional <Vessel> findById(Long id) {
        return vesselRepository.findById(id);
    }

    @Override
    public Vessel updateVessel(Long id, Vessel vessel) {
        Optional<Vessel> optionalVessel = vesselRepository.findById(id);
        if (optionalVessel.isPresent()) {
            Vessel vesselToUpdate = optionalVessel.get();

            // Perform necessary updates to the existingVessel object
            vesselToUpdate.setName(vessel.getName());
            vesselToUpdate.setType(vessel.getType());

            List<ShippingRoute> updatedShippingRoutes = vessel.getShippingRoute();
            List<ShippingRoute> existingShippingRoutes = vesselToUpdate.getShippingRoute();

            // Update each shipping route in the list
            for (int i = 0; i < updatedShippingRoutes.size(); i++) {
                ShippingRoute updatedRoute = updatedShippingRoutes.get(i);
                ShippingRoute existingRoute = existingShippingRoutes.get(i);

                existingRoute.setPort(updatedRoute.getPort());
                existingRoute.setDate_of_arrival(updatedRoute.getDate_of_arrival());
                existingRoute.setPurpose_of_travel(updatedRoute.getPurpose_of_travel());
                existingRoute.setTax_fees_port_expenses(updatedRoute.getTax_fees_port_expenses());
            }

            
            // Save the updated vessel
            return vesselRepository.save(vesselToUpdate);
        } else {
            throw new IllegalArgumentException("Vessel not found with ID: " + id);
        }
    }

    @Override
    public void deleteVessel(Long id) {
        vesselRepository.deleteById(id);
    }


    //   @Override
    // public Booking addBookingToVessel(Long id, Booking booking) {
    //     Optional<Vessel> optionalVessel = vesselRepository.findById(id);
    //     if (optionalVessel.isPresent()) {
    //         Vessel existingVessel = optionalVessel.get();
    //         booking.setVessel(existingVessel);
    //         return bookingRepository.save(booking);
    //     } else {
    //         throw new IllegalArgumentException("Vessel not found with ID: " + id);
    //     }
    // }


    //  @Override
    // public ShippingRoute addShippingRouteToVessel(Long id, ShippingRoute shippingRoute) {
    //     Optional<Vessel> optionalVessel = vesselRepository.findById(id);
    //     if (optionalVessel.isPresent()) {
    //         Vessel existingVessel = optionalVessel.get();
    //         shippingRoute.setVessel(existingVessel);
    //         return shippingRouteRepository.save(shippingRoute);
    //     } else {
    //         throw new IllegalArgumentException("Vessel not found with ID: " + id);
    //     }
    // }
    


    }