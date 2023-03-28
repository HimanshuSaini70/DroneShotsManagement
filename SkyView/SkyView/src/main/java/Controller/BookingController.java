package Controller;

import Entity.Booking;
import Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String getAllBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }

    @GetMapping("/{id}")
    public String getBookingById(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("booking", booking);
        return "booking";
    }

    @GetMapping("/create")
    public String showCreateBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "create-booking";
    }

    @PostMapping("/create")
    public String createBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.createBooking(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateBookingForm(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("booking", booking);
        return "update-booking";
    }

    @PostMapping("/{id}/edit")
    public String updateBooking(@PathVariable Long id, @ModelAttribute("booking") Booking booking) {
        booking.setBookingId(id);
        bookingService.updateBooking(booking);
        return "redirect:/bookings";
    }

    @DeleteMapping("/{id}")
    public String deleteBookingById(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
        return "redirect:/bookings";
    }
}
