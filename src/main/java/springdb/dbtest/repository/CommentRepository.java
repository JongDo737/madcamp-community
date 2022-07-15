package springdb.dbtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdb.dbtest.entity.Board;
import springdb.dbtest.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {



    List<Comment> findAllByBoard(Long boardid);

    @Query("select DISTINCT c from Comment c join fetch c.recomments where c.id = :commentid") // (1)
    List<Comment> findAllWithRecommentUsingFetchJoin(Long commentid);


}
