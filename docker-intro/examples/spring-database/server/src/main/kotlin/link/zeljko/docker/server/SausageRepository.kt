package link.zeljko.docker.server

import org.springframework.data.repository.CrudRepository

interface SausageRepository : CrudRepository<Sausage, Int>