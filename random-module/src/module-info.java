import com.example.random.service.RandomService;
import com.example.random.service.business.SecureRandomService;
import com.example.random.service.business.StandardRandomService;

module com.example.random {
	exports com.example.random.service;
	provides RandomService with StandardRandomService, SecureRandomService;
}