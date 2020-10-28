/*  backend 
    Copyright (C) 2020 nanoseeds
    
    backend is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    backend is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
    */
/**
 * @Github: https://github.com/Certseeds/backend
 * @Organization: SUSTech
 * @Author: nanoseeds
 * @Date: 2020-10-26 11:11:10
 * @LastEditors : nanoseeds
 */
package sustech.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RegisterController {


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("name", "");
        return "login";
    }

    @GetMapping("/login/{name}")
    public String login(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
}