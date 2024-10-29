// Problem Statement

var find_missing_element = function (array) {
  let left = 0;
  let right = array.length - 1;

  while (left <= right) {
    let mid = Math.round(left + (right - left) / 2);
    if (array[mid] == mid + 1) {
      // Move Right
      left = mid + 1;
    } else {
      // Check if
      right = mid - 1;
    }
  }
  return left + 1;
};

// Tests
test("Scenario #1:", () => {
  expect(find_missing_element([1, 2, 3, 4, 6, 7, 8])).toStrictEqual(5);
});

test("Scenario #2:", () => {
  expect(find_missing_element([2, 3, 4, 5, 6, 7, 8])).toStrictEqual(1);
});

test("Scenario #3:", () => {
  expect(find_missing_element([1, 2, 3, 4, 5])).toStrictEqual(6);
});

test("Scenario #4:", () => {
  expect(find_missing_element([1, 3, 4, 5])).toStrictEqual(2);
});

test("Scenario #5:", () => {
  expect(find_missing_element([2, 3, 4, 5])).toStrictEqual(1);
});