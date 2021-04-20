package com.epam.rd.autotasks.segments;

import static java.lang.Math.*;
import static java.lang.StrictMath.pow;

class Segment {

    public Point start;
    public Point end;

    public Segment(Point start, Point end) {
        if(start.getX()!=end.getX() || start.getY()!=end.getY()){
        this.start = start;
        this.end = end;
        }
        else throw new RuntimeException();
    }

    double length() {
        return Math.sqrt(Math.pow((start.getX() - end.getX()), 2) + Math.pow((start.getY() - end.getY()), 2));
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {

        if(collinChek(another)==true)
            return null;

        double x1, x2, x3, x4, y1, y2, y3, y4;
        x1 = start.getX();
        x2 = end.getX();
        y1 = start.getY();
        y2 = end.getY();
        x3 = another.start.getX();
        x4 = another.end.getX();
        y3 = another.start.getY();
        y4 = another.end.getY();

        double a = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double r = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

        if (a <= 1 && a >= 0 && r <= 1 && r >= 0) {
            double x = x1 + a * (x2 - x1);
            double y = y1 + a * (y2 - y1);
            return new Point(x, y);
        }
        else return null;
    }


    boolean collinChek (Segment another) {
        double vecAx;
        double vecAy;
        double vecBx;
        double vecBy;
        vecAx = start.getX() - end.getX();
        vecAy = start.getY() - end.getY();
        vecBx = another.start.getX() - another.end.getX();
        vecBy = another.start.getY() - another.end.getY();
        if ((vecAx * vecBy) == (vecAy * vecBx)) {
            return true;
        }

        return false;
    }
    }



