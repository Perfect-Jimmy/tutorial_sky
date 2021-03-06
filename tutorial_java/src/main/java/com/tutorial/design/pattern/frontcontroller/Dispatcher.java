package com.tutorial.design.pattern.frontcontroller;

/**
 * @author jimmy
 * @date 2020/7/26
 */
public class Dispatcher {
    private StudentView studentView;
    private HomeView homeView;
    public Dispatcher(){
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request){
        if(request.equalsIgnoreCase("STUDENT")){
            studentView.showStudent();
        }else{
            homeView.showHome();
        }
    }
}
