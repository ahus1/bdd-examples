package de.ahus1.bdd

import com.shazam.gwen.gwt.{Then, When, Given}

trait GwenTrait {
  def given[T](x: Given[T]): T = return x given

  def when[T](x: When[T]): T = return x when

  def then[T](x: Then[T]): T = return x then
}
