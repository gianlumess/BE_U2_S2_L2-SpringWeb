package gianlucamessina.BE_U2_S2_L2_SpringWeb.controllers;

import gianlucamessina.BE_U2_S2_L2_SpringWeb.entities.BlogPost;
import gianlucamessina.BE_U2_S2_L2_SpringWeb.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    @Autowired
    BlogPostsService blogPostsService;

    //GET CHE RITORNA LA LISTA DI BLOG POST (http://localhost:3001/blogPosts)
    @GetMapping
    private List<BlogPost> getAllBlogPosts(){
        return blogPostsService.findAll();
    }

    //GET CHE RITORNA UN SINGOLO BLOG POST (http://localhost:3001/blogPosts/{blogPostId})
    @GetMapping("/{blogPostId}")
    private BlogPost getBlogPostById(@PathVariable int blogPostId){
        return blogPostsService.findById(blogPostId);
    }

    //POST CHE PERMETTE DI CREARE UN BLOG POST (http://localhost:3001/blogPosts)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost createBlogPost(@RequestBody BlogPost body){
        return blogPostsService.saveBlogPost(body);
    }

    //PUT PER MODIFICARE UN BLOG POST

    @PutMapping("/{blogPostId}")
    private BlogPost findBlogPostByIdAndUpdate(@PathVariable int blogPostId,@RequestBody BlogPost blogPost){
        return blogPostsService.findByIdAndUpdate(blogPostId,blogPost);
    }

    //DELETE DI UN BLOG POST

    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findBlogPostByIdAndDelete(@PathVariable int blogPostId){
       blogPostsService.findByIdAndDelete(blogPostId);
    }
}
