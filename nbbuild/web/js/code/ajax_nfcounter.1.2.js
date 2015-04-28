/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//       {"message":[{"id":"39474","time":"10:34:40 AM","location":"Major District Road 896","date":"25-09-2014"},
            //        {"id":"4805","time":"09:59:19 AM","location":"Elephant Feeding Camp Road","date":"25-09-2014"}]}
            //
            function getNfCounter(){
                $.ajax({
                    type:"post",
                    url:"AjaxNotificationCounterServlet",
                    data:{"type" : TYPE},
                    success:function(result){
                        var jsonArray = JSON.parse(result);
                        console.log(result);
                        var objs =  jsonArray.message;
                        var span = document.getElementById('nf_count');
                        span.textContent = objs.length;
                        console.log('objs:' + objs.length);
                        var html = ' <div class="cols3">';
                        for(var obj in objs){
                            console.log(objs[obj].location);
                            html = html + ' <div class="col3"> <h4><a href="#'+objs[obj].id+'" class="scroll"> Near '+objs[obj].location+'</a></h4></div>' ;
                            
                        }
                        html = html + '</div>';
                        $('#nf_link').append(html);
                    }

                });
                
                //-----------------Get Notified Details-------------------
                //{"post":"2","blog":"2"}
                $.ajax({
                    type:"post",
                    url:"AjaxFinshedTaskHandler",
                    data:{type:TYPE},
                    success : function(result){
                        var jsonObj =   JSON.parse(result);
                        var post = document.getElementById('post');
                        post.textContent = jsonObj.post;
                        var blog =  document.getElementById('blog');
                        blog.textContent = jsonObj.blog;
                        // $('#blog').append(jsonObj.blog);
                    }
                });
                
                //setTimeout(getNfCounter(),4000);
                setTimeout('getNfCounter()', 5000);

            }

