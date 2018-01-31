package link.zeljko.docker.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 *
 * @author Zeljko Trogrlic
 */
@RestController
@RequestMapping("/sausages")
class SausageController @Autowired constructor(val sausageRepository: SausageRepository) {

    @GetMapping
    fun getSausages() = sausageRepository.findAll()

    @GetMapping("{id}")
    fun getSausage(@PathVariable id: Int) = sausageRepository.findById(id)

    @PostMapping
    fun create(@RequestBody sausage: Sausage) = sausageRepository.save(sausage).let { it.id }

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody sausage: Sausage) = sausage.also {
        sausage.id = id
        sausageRepository.save(sausage)
    }
}
