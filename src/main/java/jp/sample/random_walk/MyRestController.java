package jp.sample.random_walk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyRestController {
	private static double r = Math.sqrt(0.0095*0.0095 + 0.0008*0.0008);

	@GetMapping("/rest/random_route")
	public RandomRouteData getRandomRoute() {
		int seed = (int)System.currentTimeMillis();
		Random rand = new Random(seed);
		int count = 1 + rand.nextInt(9);
		Point start = new Point(35.6895, 139.6917);
		Point prev = null;
		List<Point> route = new ArrayList<>();
		route.add(start);
		
		for (int i = 0; i < count; i++) {
			double theta = 2.0 * Math.PI * rand.nextDouble();
			double lat = prev == null ? start.getLat() : prev.getLat();
			double lng = prev == null ? start.getLng() : prev.getLng();
			Point p = new Point(lat + r * Math.cos(theta), lng + r * Math.sin(theta));
			route.add(p);
			prev = p;
		}
		
		var ret = new RandomRouteData();
		ret.setRoute(route);
		
		return ret;
	}
}
