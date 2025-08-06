package aero.sita.bordermanagement.uae.gw.bean;

import org.junit.jupiter.api.Test;
import java.sql.Date;

import org.junit.jupiter.api.Assertions;

public class AirlineEnrollmentTest {

	@Test
	public void testGettersAndSetters() {
		AirlineEnrollment enrollment = new AirlineEnrollment();

		Long enrollmentId = 123L;
		String serviceId = "service123";
		Date startDate = Date.valueOf("2025-06-01");
		Date endDate = Date.valueOf("2026-06-01");
		Date createdDate = Date.valueOf("2025-01-01");
		Date modifiedDate = Date.valueOf("2025-05-01");
		String requestQueue = "reqQueue";
		String responseQueue = "respQueue";
		boolean autoResponder = true;
		String channelName = "channelX";
		String userId = "user1";

		enrollment.setEnrollmentId(enrollmentId);
		enrollment.setSenderSystem(serviceId);
		enrollment.setEnrollmentStartDate(startDate);
		enrollment.setEnrollmentEndDate(endDate);
		enrollment.setCreatedDate(createdDate);
		enrollment.setLastModifiedDate(modifiedDate);
		enrollment.setServiceRequestQueue(requestQueue);
		enrollment.setServiceResponseQueue(responseQueue);
		enrollment.setAutoResponder(autoResponder);
		enrollment.setChannelName(channelName);
		enrollment.setUserId(userId);

		Assertions.assertEquals(enrollmentId, enrollment.getEnrollmentId());
		Assertions.assertEquals(serviceId, enrollment.getSenderSystem());
		Assertions.assertEquals(startDate, enrollment.getEnrollmentStartDate());
		Assertions.assertEquals(endDate, enrollment.getEnrollmentEndDate());
		Assertions.assertEquals(createdDate, enrollment.getCreatedDate());
		Assertions.assertEquals(modifiedDate, enrollment.getLastModifiedDate());
		Assertions.assertEquals(requestQueue, enrollment.getServiceRequestQueue());
		Assertions.assertEquals(responseQueue, enrollment.getServiceResponseQueue());
		Assertions.assertEquals(autoResponder, enrollment.isAutoResponder());
		Assertions.assertEquals(channelName, enrollment.getChannelName());
		Assertions.assertEquals(userId, enrollment.userId());

	}

	@Test
	public void testToString() {
		AirlineEnrollment enrollment = new AirlineEnrollment();

		Long enrollmentId = 123L;
		String serviceId = "service123";
		Date startDate = Date.valueOf("2025-06-01");
		Date endDate = Date.valueOf("2026-06-01");
		Date createdDate = Date.valueOf("2025-01-01");
		Date modifiedDate = Date.valueOf("2025-05-01");
		String requestQueue = "reqQueue";
		String responseQueue = "respQueue";
		boolean autoResponder = true;
		String channelName = "channelX";
		String userId = "user1";

		enrollment.setEnrollmentId(enrollmentId);
		enrollment.setSenderSystem(serviceId);
		enrollment.setEnrollmentStartDate(startDate);
		enrollment.setEnrollmentEndDate(endDate);
		enrollment.setCreatedDate(createdDate);
		enrollment.setLastModifiedDate(modifiedDate);
		enrollment.setServiceRequestQueue(requestQueue);
		enrollment.setServiceResponseQueue(responseQueue);
		enrollment.setAutoResponder(autoResponder);
		enrollment.setChannelName(channelName);
		enrollment.setUserId(userId);

		String toStringResult = enrollment.toString();

		// Assert that the toString contains expected substrings (fields and their
		// values)
		Assertions.assertTrue(toStringResult.contains("enrollmentId=" + enrollmentId));
		Assertions.assertTrue(toStringResult.contains("serviceId=" + serviceId));
		Assertions.assertTrue(toStringResult.contains("enrollmentStartDate=" + startDate));
		Assertions.assertTrue(toStringResult.contains("enrollmentEndDate=" + endDate));
		Assertions.assertTrue(toStringResult.contains("createdDate=" + createdDate));
		Assertions.assertTrue(toStringResult.contains("lastModifiedDate=" + modifiedDate));
		Assertions.assertTrue(toStringResult.contains("serviceRequestQueue=" + requestQueue));
		Assertions.assertTrue(toStringResult.contains("serviceResponseQueue=" + responseQueue));
		Assertions.assertTrue(toStringResult.contains("autoResponder=" + autoResponder));
		Assertions.assertTrue(toStringResult.contains("channelName=" + channelName));
		Assertions.assertTrue(toStringResult.contains("userId=" + userId));
	}
}
