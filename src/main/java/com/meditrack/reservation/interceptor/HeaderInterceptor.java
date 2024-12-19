package com.meditrack.reservation.interceptor;

import com.meditrack.reservation.constant.ErrorCode;
import com.meditrack.reservation.exception.ReservationInvalidRequestException;
import com.meditrack.reservation.service.HeaderReadService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class HeaderInterceptor implements HandlerInterceptor {


    private final HeaderReadService headerReadService;

    /**
     * Create a new WebRequestHandlerInterceptorAdapter for the given WebRequestInterceptor.
     *
     * @param requestInterceptor the WebRequestInterceptor to wrap
     */
    public HeaderInterceptor(WebRequestInterceptor requestInterceptor, HeaderReadService headerReadService) {
        this.headerReadService = headerReadService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Extract details from the header
        String hospital = request.getHeader("x-hospital");
        String user = request.getHeader("x-user");
        // Set the details to the context
        try {
            headerReadService.setHeaderDetailsToContext(Long.parseLong(hospital), user);
        } catch (Exception e) {
            log.error("Error while setting the tenant details to the context.", e);
            String headerPath = request.getRequestURI();
            if (headerPath.contains("/rs/swagger-ui.html") || headerPath.contains("/rs/v3/api-docs") || headerPath.contains("/rs/swagger-ui/")) {
                return true;
            }
            throw new ReservationInvalidRequestException(ErrorCode.PRM_003002, "Invalid header details/ header details are missing. x-hospital and x-user are mandatory headers.");
        }
        return true;
    }
}

