package com.arsenydeveloper.applang.config.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * TrailingSlashFilter
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Component
@Order(1)
public class TrailingSlashFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        URI originalUri = URI.create(request.getRequestURL().toString());

        if (shouldRedirect(originalUri)) {
            String pathWithoutTrailingSlash = originalUri.getPath().substring(0, originalUri.getPath().length() - 1);

            try {
                URI newUri = new URI(originalUri.getScheme(), originalUri.getUserInfo(), originalUri.getHost(),
                        originalUri.getPort(), pathWithoutTrailingSlash, originalUri.getQuery(), originalUri.getFragment());

                response.setStatus(HttpStatus.MOVED_PERMANENTLY.value());
                response.setHeader("Location", newUri.toString());
                return;
            } catch (URISyntaxException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean shouldRedirect(URI uri) {
        String path = uri.getPath();
        return path.endsWith("/") && !path.equals("/");
    }
}
