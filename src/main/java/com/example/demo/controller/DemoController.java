/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.demo.controller;

import com.example.demo.model.Demo;
import com.example.demo.repo.DemoRepository;
import com.example.demo.spec.DemoSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created Kelvin Santiago on 08/04/19.
 */

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;

    @GetMapping("/{id}")
    public Object getAll(DemoSpec demoSpec) {
        return demoRepository.findAll(demoSpec);
    }

    @GetMapping("/add")
    public Object save(@RequestParam String name) {
        Demo demo = new Demo();
        demo.setName(name);
        return demoRepository.save(demo);
    }

}