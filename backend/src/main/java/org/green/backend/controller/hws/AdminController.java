package org.green.backend.controller.hws;


import lombok.RequiredArgsConstructor;
import org.green.backend.dto.hws.CompanyDto;
import org.green.backend.dto.hws.UserDto;
import org.green.backend.service.hws.CompanyService;
import org.green.backend.service.hws.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping
    public Page<UserDto> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.getAllUsers(pageable);
    }

    @PutMapping("/{username}")
    public String userStatusChange(@PathVariable String username) {
        return userService.userStatusChange(username);
    }

    @GetMapping("/company")
    public Page<CompanyDto> getAllCompanys(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return companyService.getAllUsers(pageable);
    }

    @PutMapping("/company/{username}")
    public String companyServiceStatusChange(@PathVariable String username) {
        return companyService.companyStatusChange(username);
    }

}
