<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Main</title>
        <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/img/logo.png">
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
            crossorigin="anonymous">
        <script src="jquery-3.5.1.min.js"></script>
        <script
            src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

        <style>
            #logo{
                padding: 10px;
            }
            #mypageSection{
                text-align: right;
                padding-top: 2em;
            }
            div#mypageSection>ul>li{
                display: inline;
                margin-left: 1em;
            }
            li>a{
                text-decoration: none;
                color: black;
            }
            input[type="search"]{
                margin-left: 1em;
            }
            #searchBtn{
                color: brown;
                border: 1px brown solid;
            }
            #searchBtn:hover{
                background-color: bisque;
            }
            li.nav-item{
                margin-left: 3em;
                margin-right: 7.5em;
            }
            .board {
                height: 35em;
            }
            .board>h3 {
                text-align: center;
            }
            footer {
                height: 15em;
                background-color: gray;
                text-align:center;
            }
        </style>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm" id="logo">
                            <form class="form-inline">
                                <a href="">
                                <img src="img/logoTitle.png" width="200" height="66">
                            </a>
                            <input class="form-control mr-sm-2" type="search" placeholder="물건 색" aria-label="Search">
                            <button id="searchBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
                          </form>
                        </div>

                        <div class="col-sm" id="mypageSection">
                            <ul>
                            <li><a href="<%= request.getContextPath() %>/views/member/login.jsp">로그인</a></li>
                            <li><a href="">회원가입</a></li>
                            <li><a href="">고객센터</a></li>
                            <li><a href="">마이페이지</a></li>
                        </ul>
                        </div>
                    </div>
                </div>
            </header>
            <section>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                      <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                특가
                              </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                식품
                              </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                패션잡화
                              </a>
                        </li>
                        <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            취미-문구
                          </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              티켓
                            </a>
                          </li>
                          <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              애완용품
                            </a>
                          </li>
                      </ul>
                    </div>
                  </nav>
                <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                      <div class="carousel-item active" data-interval="10000">
                        <img src="<%=request.getContextPath()%>/img/img1.jpg" class="d-block w-100" alt="..." height="500em">
                      </div>
                      <div class="carousel-item" data-interval="2000">
                        <img src="<%=request.getContextPath()%>/img/img2.jpg" class="d-block w-100" alt="..." height="500em">
                      </div>
                      <div class="carousel-item">
                        <img src="<%=request.getContextPath()%>/img/img3.jpg" class="d-block w-100" alt="..." height="500em">
                      </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                    </a>
                  </div>
                  <div class="container">
                    <div class="row">
                      <div class="col-sm-2">
                      </div>
                      <div class="col-sm-4 board">
                        <h3>인기게시물</h3>
                        <p>암모니아(분자식:NH3)는 질소와 수소로 이루어진 화합물이다. 상온에서는 특유의 자극적인 냄새를 가진 기체 상태로 존재한다. 암모니아라는 이름은 고대 이집트의 신인 암몬의 사원 근처에서 염화 암모늄이 산출되어, 그것을 ‘암몬의 염’이라고 부른 것에서 유래한다. 중세 시대에 염화 암모늄에 알칼리를 가하면 얻을 수 있다는 사실이 처음으로 알려졌다. 1913년부터는 프리츠 하버와 카를 보슈에 의해 암모니아의 대량 생산 공정인 하버법이 개발되었다. 현재 암모니아는 공업적으로 가장 많이 생산되는 화합물 중 하나이며, 주로 합성 비료나 질산, 또는 다른 암모늄염의 합성 원료로 사용된다.

                            생태계에서는 주로 공기 중의 질소를 질소고정세균 등의 세균이 암모늄염, 요소 등으로 고정하는 과정에서 생성되거나, 단백질 대사의 부산물로 만들어진다. 암모니아는 염기성 물질이므로, 생체 조직에 대해 자극성을 지니며, 장기간 노출되면 피부 손상 등의 증상이 나타난다. 또한, 대기 중에 짙은 농도로 존재하면 질식사할 가능성도 있다. 그래서 단백질 대사의 부산물로 생성된 암모니아는 그대로 배설되거나 요소, 요산 등으로 바뀌어서 몸 밖으로 배설된다.</p>
                      </div>
                      <div class="col-sm-4 board">
                        <h3>베스트후기</h3>
                        <p>암모니아(분자식:NH3)는 질소와 수소로 이루어진 화합물이다. 상온에서는 특유의 자극적인 냄새를 가진 기체 상태로 존재한다. 암모니아라는 이름은 고대 이집트의 신인 암몬의 사원 근처에서 염화 암모늄이 산출되어, 그것을 ‘암몬의 염’이라고 부른 것에서 유래한다. 중세 시대에 염화 암모늄에 알칼리를 가하면 얻을 수 있다는 사실이 처음으로 알려졌다. 1913년부터는 프리츠 하버와 카를 보슈에 의해 암모니아의 대량 생산 공정인 하버법이 개발되었다. 현재 암모니아는 공업적으로 가장 많이 생산되는 화합물 중 하나이며, 주로 합성 비료나 질산, 또는 다른 암모늄염의 합성 원료로 사용된다.

                            생태계에서는 주로 공기 중의 질소를 질소고정세균 등의 세균이 암모늄염, 요소 등으로 고정하는 과정에서 생성되거나, 단백질 대사의 부산물로 만들어진다. 암모니아는 염기성 물질이므로, 생체 조직에 대해 자극성을 지니며, 장기간 노출되면 피부 손상 등의 증상이 나타난다. 또한, 대기 중에 짙은 농도로 존재하면 질식사할 가능성도 있다. 그래서 단백질 대사의 부산물로 생성된 암모니아는 그대로 배설되거나 요소, 요산 등으로 바뀌어서 몸 밖으로 배설된다.</p>
                      </div>
                      <div class="col-sm-2">
                      </div>
                    </div>
                  </div>
            </section>

            <footer>
                <p>footer</p>
            </footer>
        </div>
        <script>

        </script>
    </body>
</html>