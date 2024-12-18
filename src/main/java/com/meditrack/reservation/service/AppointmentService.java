@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment getAppointmentById(Long id) {
        // Replace with actual database call
        return appointmentRepository.findById(id).orElse(null);
    }
}
