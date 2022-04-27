import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class TreeNodeTest : DescribeSpec({
    describe("exists") {
        context("when root has given value") {
            it("returns true") {
                TreeNode(10).exists(10).shouldBeTrue()
                TreeNode("abcde").exists("abcde").shouldBeTrue()
            }
        }

        context("when root doesn't have given value") {
            it("returns false") {
                TreeNode(10).exists(1).shouldBeFalse()
                TreeNode("abcde").exists("abcd").shouldBeFalse()
            }
        }

        context("when leaf node has given value") {
            it("returns true") {
                val tree = TreeNode(10)
                    .add(5)
                    .add(15)
                    .add(4)
                    .add(3)
                    .add(2)
                    .add(1)

                tree.exists(10).shouldBeTrue()
                tree.exists(5).shouldBeTrue()
                tree.exists(15).shouldBeTrue()
                tree.exists(4).shouldBeTrue()
                tree.exists(3).shouldBeTrue()
                tree.exists(2).shouldBeTrue()
                tree.exists(1).shouldBeTrue()

                val stringTree = TreeNode("abc")
                    .add("ab")
                    .add("abcd")

                stringTree.exists("ab").shouldBeTrue()
                stringTree.exists("abc").shouldBeTrue()
                stringTree.exists("abcd").shouldBeTrue()
            }
        }
    }
})
