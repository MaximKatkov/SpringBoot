<#import "blocks/template.ftlh" as t>
<@t.template user>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <#list images as image>
                <li data-target="#myCarousel" data-slide-to="0" class=""></li>
            </#list>
        </ol>
        <div class="carousel-inner">
            <#list images as image>
                <div class="carousel-item <#if image.previewImage>active</#if>">
                    <svg class="bd-placeholder-img" width="1512px" height="512px" xmlns="http://www.w3.org/2000/svg"
                         role="img" aria-label=" :  " preserveAspectRatio="xMidYMid slice" focusable="false">
                        <title></title>
                        <rect width="1512px" height="512px" fill=#D3D3D3></rect>
                        <text x="100px" y="100px" fill=#D3D3D3 dy=".3em"></text>
                    </svg>

                    <div class="container">
                        <div class="carousel-caption">
                            <a href="/images/${image.id}" >
                                <img class="product" style="height: 400px" src="/images/${image.id}" width="600px"  >
                            </a>
                        </div>
                    </div>
                </div>
            </#list>

        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <hr>
<#--    <p><h1 style="text-align: center">${product.title} | ${product.grade_like} ❤</h1></p>-->
<#--    <form action="/product/${product.id}" method="post">-->
<#--        <input type="submit" value="Лайк"/>-->
    </form>
    <p style="text-align: center">${product.description}</p>
    <p style="text-align: center">Номер телефона: <b>${authorProduct.phoneNumber}</b></p>

    <hr>
    <p style="text-align: center">
        <a href="/user/${authorProduct.id}">
            <img src="/static/images/avatar.png" alt="mdo" width="32" height="32" class="rounded-circle"> ${authorProduct.name}
        </a>
    </p>

</@t.template>