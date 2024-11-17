import com.example.random.service.RandomService;

module com.example.lottery {
	requires com.example.random;
	uses RandomService;
}